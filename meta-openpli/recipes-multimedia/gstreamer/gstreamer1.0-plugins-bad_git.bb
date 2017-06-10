require gstreamer1.0-plugins-bad.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=73a5855a8119deb017f5f13cf327095d \
                    file://COPYING.LIB;md5=21682e4e8fea52413fd26c60acb907e5 \
"

S = "${WORKDIR}/git"

UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>(\d+(\.\d+)+))"

SRCREV_FORMAT = "base"

SRC_URI = " \
	git://anongit.freedesktop.org/gstreamer/gst-plugins-bad;branch=master;name=base \
	git://anongit.freedesktop.org/gstreamer/common;destsuffix=git/common;name=common \
	file://configure-allow-to-disable-libssh2.patch \
	file://0001-Makefile.am-don-t-hardcode-libtool-name-when-running-pbad.patch \
	file://0001-rtmp-fix-seeking-and-potential-segfault.patch \
	file://0004-rtmp-hls-tsdemux-fix.patch \
	file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
	file://fix-maybe-uninitialized-warnings-when-compiling-with-Os.patch \
	file://dvbapi5-fix-old-kernel.patch \
	file://hls-main-thread-block.patch \
"

inherit gitpkgv
PV = "1.12.00+git${SRCPV}"
PKGV = "1.12.00+git${GITPKGV}"

EXTRA_OECONF += " \
    --disable-openjpeg \
"

do_configure_prepend() {
	cd ${S}
	./autogen.sh --noconfigure
	cd ${B}
}

TARGET_CFLAGS_append = " -Wno-error=maybe-uninitialized -Wno-error=redundant-decls "

