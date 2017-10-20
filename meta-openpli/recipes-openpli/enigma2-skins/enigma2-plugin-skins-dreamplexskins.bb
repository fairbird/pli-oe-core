SUMMARY = "Enigma2 DreamPlex skin pack"
MAINTAINER = "OpenViX"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
PACKAGE_ARCH = "all"

require conf/license/license-gplv2.inc

VER ="1.0"

SRC_URI = "file://skins.zip"

S = "${WORKDIR}"

FILES_${PN} = "/usr/*"

do_install() {
    mkdir -p ${D}/usr/lib/enigma2/python/Plugins/Extensions/DreamPlex/skins
    cp -r ${S}/DreamPlexSkins/* ${D}/usr/lib/enigma2/python/Plugins/Extensions/DreamPlex/skins/
}
