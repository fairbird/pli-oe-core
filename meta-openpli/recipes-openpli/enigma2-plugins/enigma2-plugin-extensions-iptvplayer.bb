SUMMARY = "IPTV Player for E2"
DESCRIPTION = "IPTV Player for E2"
HOMEPAGE = "https://gitlab.com/iptvplayer-for-e2/"
SECTION = "multimedia"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://IPTVPlayer/plugin.py;md5=c2f0b154b393ac73a823d3f3161fd26b"
SRC_URI = "git://gitlab.com/iptvplayer-for-e2/iptvplayer-for-e2.git;protocol=http"

S = "${WORKDIR}/git"

inherit gitpkgv
SRCREV = "${AUTOREV}"
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

inherit allarch distutils-openplugins

RRECOMMENDS_${PN} = " \
	python-core \
	ffmpeg \
	exteplayer3 \
	gstplayer \
	wget \
	hlsdl \
	lsdir \
	f4mdump \
	gst-ifdsrc \
	iptvsubparser \
	"

PACKAGES =+ " ${PN}-src"
RDEPENDS_{PN}-src = "${PN}"
FILES_${PN}-src = " \
	${libdir}/enigma2/python/Plugins/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*/*/*/*/*/*.py \
	${libdir}/enigma2/python/Plugins/*-py2.7.egg-info/* \
	${libdir}/enigma2/python/Plugins/*/locale/*/LC_MESSAGES/*.po \
	"

deltask package_qa

