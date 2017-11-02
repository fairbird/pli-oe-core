SUMMARY = "Meta package for installing gstplayer"
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS_${PN} = "gstplayer"

PV = "1.0"
PR = "r0"

ALLOW_EMPTY_${PN} = "1"
