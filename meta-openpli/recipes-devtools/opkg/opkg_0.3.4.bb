SUMMARY = "Open Package Manager"
SUMMARY_libopkg = "Open Package Manager library"
SECTION = "base"
HOMEPAGE = "http://code.google.com/p/opkg/"
BUGTRACKER = "http://code.google.com/p/opkg/issues/list"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
                    file://src/opkg.c;beginline=2;endline=21;md5=90435a519c6ea69ef22e4a88bcc52fa0"

DEPENDS = "libarchive"

PE = "1"

SRC_URI = "http://downloads.yoctoproject.org/releases/${BPN}/${BPN}-${PV}.tar.gz \
           file://opkg-configure.service \
           file://opkg.conf \
           file://0001-opkg_conf-create-opkg.lock-in-run-instead-of-var-run.patch \
           file://status-conffile.patch \
           file://libopkg.so.1.0.0 \
           file://opkg-cl \
"

SRC_URI[md5sum] = "6c52a065499056a196e0b45a27e392de"
SRC_URI[sha256sum] = "750b900b53b62a9b280b601a196f02da81091eda2f3478c509512aa5a1ec93be"

inherit autotools pkgconfig systemd

SYSTEMD_SERVICE_${PN} = "opkg-configure.service"

target_localstatedir := "${localstatedir}"
OPKGLIBDIR = "${target_localstatedir}/lib"

PACKAGECONFIG ??= "libsolv"

PACKAGECONFIG[gpg] = "--enable-gpg,--disable-gpg,gpgme libgpg-error,gnupg"
PACKAGECONFIG[curl] = "--enable-curl,--disable-curl,curl"
PACKAGECONFIG[ssl-curl] = "--enable-ssl-curl,--disable-ssl-curl,curl openssl"
PACKAGECONFIG[openssl] = "--enable-openssl,--disable-openssl,openssl"
PACKAGECONFIG[sha256] = "--enable-sha256,--disable-sha256"
PACKAGECONFIG[pathfinder] = "--enable-pathfinder,--disable-pathfinder,pathfinder"
PACKAGECONFIG[libsolv] = "--with-libsolv,--without-libsolv,libsolv"

EXTRA_OECONF_class-native = "--localstatedir=/${@os.path.relpath('${localstatedir}', '${STAGING_DIR_NATIVE}')} --sysconfdir=/${@os.path.relpath('${sysconfdir}', '${STAGING_DIR_NATIVE}')}"

do_install_append () {
	install -d ${D}${sysconfdir}/opkg
	install -m 0644 ${WORKDIR}/opkg.conf ${D}${sysconfdir}/opkg/opkg.conf
	echo "option lists_dir ${OPKGLIBDIR}/opkg/lists" >>${D}${sysconfdir}/opkg/opkg.conf

	# We need to create the lock directory
	install -d ${D}${OPKGLIBDIR}/opkg

	if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)};then
		install -d ${D}${systemd_unitdir}/system
		install -m 0644 ${WORKDIR}/opkg-configure.service ${D}${systemd_unitdir}/system/
		sed -i -e 's,@BASE_BINDIR@,${base_bindir},g' \
			-e 's,@SYSCONFDIR@,${sysconfdir},g' \
			-e 's,@BINDIR@,${bindir},g' \
			-e 's,@SYSTEMD_UNITDIR@,${systemd_unitdir},g' \
			${D}${systemd_unitdir}/system/opkg-configure.service
	fi
}

do_install_append_dm800() {
        # Fix install ipk warinig message from telnet on dm800
        rm -f ${D}/usr/lib/libopkg.so.1.0.0
        rm -f ${D}/usr/bin/opkg-cl
	install -d ${D}/usr/lib
	install -d ${D}/usr/bin
        install -m 0755 ${WORKDIR}/libopkg.so.1.0.0 ${D}/usr/lib/libopkg.so.1.0.0
        install -m 0755 ${WORKDIR}/opkg-cl ${D}/usr/bin/opkg-cl
        ln -sf opkg-cl ${D}/usr/bin/opkg
}


RDEPENDS_${PN} = "${VIRTUAL-RUNTIME_update-alternatives} opkg-arch-config libarchive"
RDEPENDS_${PN}_class-native = ""
RDEPENDS_${PN}_class-nativesdk = ""
RREPLACES_${PN} = "opkg-nogpg opkg-collateral"
RCONFLICTS_${PN} = "opkg-collateral"
RPROVIDES_${PN} = "opkg-collateral"

PACKAGES =+ "libopkg"

FILES_libopkg = "${libdir}/*.so.* ${OPKGLIBDIR}/opkg/"
FILES_${PN} += "${systemd_unitdir}/system/"

BBCLASSEXTEND = "native nativesdk"

CONFFILES_${PN} = "${sysconfdir}/opkg/opkg.conf"
