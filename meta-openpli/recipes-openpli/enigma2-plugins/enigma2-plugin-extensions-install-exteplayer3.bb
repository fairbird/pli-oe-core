SUMMARY = "Meta package for installing exteplayer3"
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS_${PN} = "exteplayer3"

PV = "1.0"
PR = "r0"

ALLOW_EMPTY_${PN} = "1"
