SUMMARY = "QT browser for HbbTV"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "CLOSED"
require conf/license/license-close.inc
PACKAGE_ARCH := "${MACHINE_ARCH}"

SRCDATE = "20170928"

SRC_URI = "file://qthbbtv-106.zip"

PV = "1.1"
PR = "${SRCDATE}"

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

S = "${WORKDIR}/files"

FILES_${PN} =  "${bindir} ${libdir}"

do_install() {
    install -d ${D}${libdir}/enigma2/python/Plugins/Extensions/QtHbbtv
    install -m 0755 ${S}/__init__.py ${D}${libdir}/enigma2/python/Plugins/Extensions/QtHbbtv
    install -m 0755 ${S}/browser.py ${D}${libdir}/enigma2/python/Plugins/Extensions/QtHbbtv
    install -m 0755 ${S}/datasocket.py ${D}${libdir}/enigma2/python/Plugins/Extensions/QtHbbtv
    install -m 0755 ${S}/hbbtv.py ${D}${libdir}/enigma2/python/Plugins/Extensions/QtHbbtv
    install -m 0755 ${S}/plugin.py ${D}${libdir}/enigma2/python/Plugins/Extensions/QtHbbtv
    install -d ${D}${bindir}
    install -m 0755 ${S}/qthbbtv ${D}${bindir}
    install -d ${D}${libdir}/mozilla/plugins
    install -m 0755 ${S}/libnpapihbbtvplugin.so ${D}${libdir}/mozilla/plugins
    ln -s /usr/share/fonts ${D}${libdir}/fonts
}

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

INSANE_SKIP_${PN} += "already-stripped"
