PROVIDES += "virtual/kodi"
RPROVIDES_${PN} += "virtual/kodi"
PACKAGE_ARCH = "${MACHINE}"

FILESEXTRAPATHS_prepend := "${THISDIR}/kodi-17:"

SRC_URI_append = "\
	file://kodi-platform-support.patch \
	file://brcmstb-settings.patch \
	file://input-devices.patch \
	file://e2player.patch \
	file://quit.patch \
	${@bb.utils.contains('MACHINE_FEATURES', 'v3d-nxpl', 'file://EGLNativeTypeV3D-nxpl.patch', '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'mali', 'file://EGLNativeTypeMali.patch', '', d)} \
	"

SRC_URI_append_osmega = " file://EGLNativeTypeV3D-platform.patch "

DEPENDS_apppend =  " \
	bluez5 \
	libbluray \
	nfs-utils \
	libupnp \
	"

EXTRA_OECONF_append_bre2ze4k = "--with-gpu=v3d "
EXTRA_OECONF_append_hd51 = " --with-gpu=v3d "
EXTRA_OECONF_append_vs1500 = " --with-gpu=v3d "
EXTRA_OECONF_append_hd2400 = " --with-gpu=v3d "
EXTRA_OECONF_append_h7 = " --with-gpu=v3d "
EXTRA_OECONF_append_osmega = " --with-gpu=v3dplatform "
EXTRA_OECONF_append_wetekplay = " --with-gpu=mali "

EXTRA_KODI ?= "empty"
EXTRA_KODI_vuduo2 = "vuplus"
EXTRA_KODI_vusolo2 = "vuplus"
EXTRA_KODI_vusolo4k = "vuplus4k"
EXTRA_KODI_vusolose = "vuplus"
EXTRA_KODI_vuultimo4k = "vuplus4k"
EXTRA_KODI_vuuno4k = "vuplus4k"
EXTRA_KODI_vuuno4kse = "vuplus4k"

DEPENDS_append_hd51 = " hd-v3ddriver-headers "
DEPENDS_append_vs1500 = " hd-v3ddriver-headers "
DEPENDS_append_hd2400 = " hd-v3ddriver-headers "
DEPENDS_append_bre2ze4k = " hd-v3ddriver-headers "
DEPENDS_append_wetekplay = " opengl-amlogic "
DEPENDS_append_osmega = " v3d-libgles-${MACHINE} "
DEPENDS_append_h7 = " zgemma-v3ddriver-headers "
DEPENDS_append_vuduo2 = " libgles-${MACHINE} "
DEPENDS_append_vuuno4k = " libgles-${MACHINE} "
DEPENDS_append_vuuno4kse = " libgles-${MACHINE} "
DEPENDS_append_vuultimo4k = " libgles-${MACHINE} "
DEPENDS_append_vusolo2 = " libgles-${MACHINE} "
DEPENDS_append_vusolo4k = " libgles-${MACHINE} "
DEPENDS_append_vusolose = " libgles-${MACHINE} "

RDEPENDS_${PN}_append_hd51 = " hd-v3ddriver-${MACHINE} hd-qteglfs-platform "
RDEPENDS_${PN}_append_vs1500 = " hd-v3ddriver-${MACHINE} hd-qteglfs-platform "
RDEPENDS_${PN}_append_hd2400 = " hd-v3ddriver-${MACHINE} hd-qteglfs-platform "
RDEPENDS_${PN}_append_bre2ze4k = " hd-v3ddriver-${MACHINE} hd-qteglfs-platform "
RDEPENDS_${PN}_append_wetekplay = " opengl-amlogic "
RDEPENDS_${PN}_append_osmega = " v3d-libgles-${MACHINE} "
RDEPENDS_${PN}_append_h7 = " zgemma-v3ddriver-${MACHINE} "
RDEPENDS_${PN}_append_vuduo2 = " libgles-${MACHINE} "
RDEPENDS_${PN}_append_vuuno4k = " libgles-${MACHINE} "
RDEPENDS_${PN}_append_vuuno4kse = " libgles-${MACHINE} "
RDEPENDS_${PN}_append_vuultimo4k = " libgles-${MACHINE} "
RDEPENDS_${PN}_append_vusolo2 = " libgles-${MACHINE} "
RDEPENDS_${PN}_append_vusolo4k = " libgles-${MACHINE} "
RDEPENDS_${PN}_append_vusolose = " libgles-${MACHINE} "

require kodi-${EXTRA_KODI}.inc
