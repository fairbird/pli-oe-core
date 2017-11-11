SUMMARY = "HbbTV for QT browser"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"

inherit gitpkgv autotools pkgconfig

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/zgemma-star/e2plugins.git;protocol=git"

PACKAGES = "${PN}"
RDEPENDS_${PN}  = "qtwebkit"
RDEPENDS_${PN}_append_hd51 = " hd-v3ddriver-${MACHINE} hd-qteglfs-platform "
RDEPENDS_${PN}_append_vs1500 = " hd-v3ddriver-${MACHINE} hd-qteglfs-platform "
RDEPENDS_${PN}_append_hd2400 = " hd-v3ddriver-${MACHINE} hd-qteglfs-platform "
RDEPENDS_${PN}_append_bre2ze4k = " hd-v3ddriver-${MACHINE} hd-qteglfs-platform "
RDEPENDS_${PN}_append_wetekplay = " opengl-amlogic "
RDEPENDS_${PN}_append_osmega = " v3d-libgles-${MACHINE} "
RDEPENDS_${PN}_append_h7 = " zgemma-v3ddriver-${MACHINE} "
RDEPENDS_${PN}_append_vuduo2 = " libgles-${MACHINE} "
RDEPENDS_${PN}_append_vuuno4k = " libgles-${MACHINE} "
RDEPENDS_${PN}_append_vuuno4kse = " libgles-${MACHINE} "
RDEPENDS_${PN}_append_vuultimo4k = " libgles-${MACHINE} "
RDEPENDS_${PN}_append_vusolo2 = " libgles-${MACHINE} "
RDEPENDS_${PN}_append_vusolo4k = " libgles-${MACHINE} "
RDEPENDS_${PN}_append_vusolose = " libgles-${MACHINE} "

S = "${WORKDIR}/git/qthbbtv"

QtHbbtv = "enigma2/python/Plugins/Extensions/QtHbbtv"

do_compile () {
}

FILES_${PN} =  "${bindir} \
	/usr/lib/mozilla/plugins \
	/usr/lib/${QtHbbtv} \
	/usr/lib/fonts"

do_install() {
	install -d ${D}/usr/lib/${QtHbbtv}
	install -m 0755 ${S}/plugin/__init__.py ${D}/usr/lib/${QtHbbtv}
	install -m 0755 ${S}/plugin/browser.py ${D}/usr/lib/${QtHbbtv}
	install -m 0755 ${S}/plugin/datasocket.py ${D}/usr/lib/${QtHbbtv}
	install -m 0755 ${S}/plugin/hbbtv.py ${D}/usr/lib/${QtHbbtv}
	install -m 0755 ${S}/plugin/plugin.py ${D}/usr/lib/${QtHbbtv}
	install -d ${D}${bindir}
	install -m 0755 ${S}/qthbbtv ${D}${bindir}
	install -d ${D}${libdir}/mozilla/plugins
	install -m 0755 ${S}/libnpapihbbtvplugin.so ${D}${libdir}/mozilla/plugins
	ln -s /usr/share/fonts ${D}${libdir}/fonts
}

PACKAGE_ARCH := "${MACHINE_ARCH}"

# prevent 'double stripping' our binaries, which will break them
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
