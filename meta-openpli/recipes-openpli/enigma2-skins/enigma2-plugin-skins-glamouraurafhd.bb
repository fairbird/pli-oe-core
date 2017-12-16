DESCRIPTION = "Glamour Aura FHD skin by MCelliot_g for OpenPLI and OpenPLI based images."
MAINTAINER = "MCelliot_g"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

inherit gitpkgv allarch

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"
PR = "r0"

RRECOMMENDS_${PN} = "enigma2-plugin-extensions-weathermsn"

SRC_URI = "git://github.com/MCelliotG/GlamourAuraFHD-skin.git;protocol=git"
SRCREV = "${AUTOREV}"

FILES_${PN} = "/usr/share/enigma2/ /usr/lib/enigma2/"

S = "${WORKDIR}/git"

do_compile() {
}

do_install() {
	install -d ${D}/usr/share
	cp -r --preserve=mode,links ${S}/usr/share/* ${D}/usr/share/
	chmod -R a+rX ${D}/usr/share/enigma2/

        install -d ${D}/usr/lib
        cp -r --preserve=mode,links ${S}/usr/lib/* ${D}/usr/lib/
        chmod -R a+rX ${D}/usr/lib/enigma2/
}
