SUMMARY = "Enigma2 Font Tiny"
MAINTAINER = "OBH"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
PACKAGE_ARCH = "all"

require conf/license/license-gplv2.inc

VER ="1.0"

SRC_URI = "file://tiny.ttf"

S = "${WORKDIR}"

FILES_${PN} = "/usr/*"

do_install() {
    mkdir -p ${D}/usr/share/fonts
    install -m 0644 ${S}/tiny.ttf ${D}/usr/share/fonts/
}
