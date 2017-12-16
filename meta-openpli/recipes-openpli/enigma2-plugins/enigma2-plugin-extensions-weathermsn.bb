DESCRIPTION = "Weather forecast for 5 days"
SUMMARY = "Weather MSN"
MAINTAINER = "Sirius"
LICENSE = "GPLv3+"
HOMEPAGE = "www.gisclub.tv"
LIC_FILES_CHKSUM = "file://python/Plugins/Extensions/WeatherMSN/plugin.py;beginline=3;endline=19;md5=10bdcaaaec8041e55835067db0506e8d"

inherit gitpkgv allarch

PV = "0.7+git${SRCPV}"
PKGV = "0.7+git${GITPKGV}"
PR = "r1"

SRC_URI = "git://github.com/Sirius0103/enigma2-plugins.git;protocol=https"
SRCREV = "ab75d3dd2ac6c26d91b52b237d3b5b55a360d93b"

FILES_${PN} = "/usr/lib/enigma2/"

S = "${WORKDIR}/git"

do_compile() {
}

do_install() {
	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions
	cp -r --preserve=mode,links ${S}/python/Plugins/Extensions/WeatherMSN ${D}/usr/lib/enigma2/python/Plugins/Extensions/
	chmod -R a+rX ${D}/usr/lib/enigma2/
}
