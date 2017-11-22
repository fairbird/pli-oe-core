SUMMARY = "Meta package for installing FFmpeg"
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS_${PN} = "ffmpeg"

PV = "1.0"
PR = "r0"

ALLOW_EMPTY_${PN} = "1"
