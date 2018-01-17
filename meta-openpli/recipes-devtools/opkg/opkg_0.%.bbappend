# The external solver disables the "list-upgradables" command, so remove it until
# that has been fixed. Just to be on the safe side, specify the package config
# explicitly here so we don't get future surprises.
PACKAGECONFIG = ""

SRC_URI += "\
	file://sanity-check-provides.patch;apply=no \
	file://0001-reuse-the-installed_files-list-when-possible.patch;apply=no \
	file://ifmod.patch;apply=no \
	file://modprobe \
	file://opkg-wget \
	"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PACKAGES =+ "opkg-wget"
FILES_opkg-wget = "${bindir}/opkg-wget"
RDEPENDS_libopkg += "opkg-wget"

do_install_prepend() {
	install -d ${D}${datadir}/opkg/intercept
	install -m 755 ${WORKDIR}/modprobe ${D}${datadir}/opkg/intercept/
	install -d ${D}${bindir}
	install -m 755 ${WORKDIR}/opkg-wget ${D}${bindir}/
}
