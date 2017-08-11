SUMMARY = "Enigma2 Skin MX HQ7"
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

SRC_URI=" \
	git://github.com/OBH-Skins/MX-HQ7-Pli.git;protocol=git \
	file://rc.patch;patch=1 \
	"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr/*"

do_install() {
    rm -Rf ${S}/usr/share/fonts
    cp -rp ${S}/usr ${D}/
}
