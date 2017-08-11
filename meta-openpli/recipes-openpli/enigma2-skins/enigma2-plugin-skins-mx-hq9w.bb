SUMMARY = "Enigma2 Skin MX HQ9W"
MAINTAINER = "OBH"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
PACKAGE_ARCH = "all"
RDEPENDS_${PN} += "font-tiny"

require conf/license/license-gplv2.inc

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
VER ="1.0"

SRC_URI= " \
	git://github.com/BlackHole/MX_HQ9W.git;protocol=git \
	file://rc.patch;patch=1 \
	file://pli.png \
	file://pli.patch;patch=1 \
"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr/*"


do_install() {
    rm -Rf ${S}/usr/uninstall
    rm -Rf ${S}/usr/share/fonts
    cp -rp ${S}/usr ${D}/
    install -m 0644 ${WORKDIR}/pli.png ${D}/usr/share/enigma2/MX_HQ9W/
}
