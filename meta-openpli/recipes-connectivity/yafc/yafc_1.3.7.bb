SUMMARY = "Yafc is yet another ftp client (with some handy features)"
DESCRIPTION = "Yafc is a command-line Linux FTP client, with a bunch of useful \
        features which make it easier to use than ftp or sftp"

HOMEPAGE = "http://www.yafc-ftp.com"
BUGTRACKER = "https://github.com/sebastinas/yafc/issues/"
MAINTAINER = "Sebastian Ramacher"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=74f65085a4958dced34e7b33cdf95eaf"

DEPENDS = "krb5 libbsd libssh openssl readline glib-2.0-native virtual/gettext"

SRCREV = "98afe0ccafe3739148609a1572db6e380f3ea5b2"
SRC_URI = "git://github.com/sebastinas/yafc.git"

S = "${WORKDIR}/git"

do_configure_prepend() {
	# Remove this macro as it's provided by glib-2.0-native
	rm -f ${S}/m4/glib-gettext.m4
}

inherit gitpkgv autotools-brokensep pkgconfig gettext
PV = "1.3.7+git${SRCPV}"
PKGV = "1.3.7+git${GITPKGV}"
