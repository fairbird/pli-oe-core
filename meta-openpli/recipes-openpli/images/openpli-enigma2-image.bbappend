# Ugly workaround to skip installing the rt7777 on receiver which feature a kernel older than 3.3
TEST07 = "${@bb.utils.contains("TARGET_ARCH", "sh4", "", "rt7777", d)}"
TEST17 = "${@bb.utils.contains("MACHINE", "dm800", "", "${TEST07}", d)}"
TEST27 = "${@bb.utils.contains("MACHINE", "dm800se", "", "${TEST17}", d)}"
TEST37 = "${@bb.utils.contains("MACHINE", "dm8000", "", "${TEST27}", d)}"
TEST47 = "${@bb.utils.contains("MACHINE", "dm800sev2", "", "${TEST37}", d)}"
TEST57 = "${@bb.utils.contains("MACHINE", "dm500hd", "", "${TEST47}", d)}"
TEST67 = "${@bb.utils.contains("MACHINE", "dm7020hd", "", "${TEST57}", d)}"
TEST77 = "${@bb.utils.contains("MACHINE", "dm7020hdv2", "", "${TEST67}", d)}"
TEST87 = "${@bb.utils.contains("MACHINE", "dm520", "", "${TEST77}", d)}"
TEST97 = "${@bb.utils.contains("MACHINE", "dm7080", "", "${TEST87}", d)}"
TESTA7 = "${@bb.utils.contains("MACHINE", "dm820", "", "${TEST97}", d)}"
RT7777 = "${@bb.utils.contains("MACHINE", "dm500hdv2", "", "${TESTA7}", d)}"

ENIGMA2_PLUGINS_append = " \
	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", " \
	enigma2-plugin-softcams-oscam-emu", " \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugin-softcams-oscam-emu \
	enigma2-plugin-extensions-youtube \
	enigma2-plugin-extensions-iptvplayer \
	enigma2-plugin-skins-mx-hq9w \
	enigma2-plugin-extensions-blurayplayer", d)} \
	"

IMAGE_INSTALL_append = " \
	${RT7777} \
	"
