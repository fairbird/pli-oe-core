SUMMARY = "Betacentauris couch flashing"
MAINTAINER = "Betacentauri"
HOMEPAGE = "https://github.com/oe-alliance/ofgwrite"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3 \
                    file://include/common.h;beginline=1;endline=17;md5=ba05b07912a44ea2bf81ce409380049c"

inherit gitpkgv

PKGV = "3.x+git${GITPKGV}"

SRC_URI = "git://github.com/oe-alliance/ofgwrite.git"

S = "${WORKDIR}/git"
EXTRA_OEMAKE=""

do_install() {
    install -d ${D}/usr/bin
    install -m 755 ${S}/ofgwrite ${D}/usr/bin
    install -m 755 ${S}/ofgwrite_bin ${D}/usr/bin
    install -m 755 ${S}/ofgwrite_test ${D}/usr/bin
}
