require dreambox-dvb-modules.inc

PR = "${INC_PR}.0"

SRC_URI[modules.md5sum] = "8cb23d8897b175684d19072087298db7"
SRC_URI[modules.sha256sum] = "017198bf264be62206979cb80549d1c74fe539b6a4467b2b35843b27843affec"

RDEPENDS_${PN} += "kernel-module-stv0299"

COMPATIBLE_MACHINE = "dm7020hd"
