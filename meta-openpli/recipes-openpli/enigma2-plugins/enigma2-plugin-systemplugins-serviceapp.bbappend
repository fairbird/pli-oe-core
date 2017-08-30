SMALLFL = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "gstplayer", "exteplayer3 gstplayer", d)}"
RRECOMMENDS_${PN} = "${@bb.utils.contains("MACHINE_FEATURES", "exteplayeronly", "exteplayer3", "${SMALLFL}", d)}"
