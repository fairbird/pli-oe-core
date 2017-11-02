# Qt packages are machine specific
QT_PACKAGES_ARCH = "${MACHINE_ARCH}"

DEPENDS_hd51 += "hd-v3ddriver-headers"
DEPENDS_vs1500 += "hd-v3ddriver-headers"
DEPENDS_hd2400 += "hd-v3ddriver-headers"
DEPENDS_wetekplay += "opengl-amlogic"
DEPENDS_osmega += "v3d-libgles-osmega"
DEPENDS_h7 += "zgemma-v3ddriver-headers"
DEPENDS_vuduo2 += "libgles-vuduo2"
DEPENDS_vuuno4k += "libgles-vuuno4k"
DEPENDS_vuultimo4k += "libgles-vuultimo4k"
DEPENDS_vusolo2 += "libgles-vusolo2"
DEPENDS_vusolo4k += "libgles-vusolo4k"
DEPENDS_vusolose += "libgles-vusolose"

PACKAGECONFIG +=  "gles2"
