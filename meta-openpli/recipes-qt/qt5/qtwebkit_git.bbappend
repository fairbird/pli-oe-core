SRC_URI += " \
        file://Enable-NPAPI-for-Qt-without-X11.patch \
"

CFLAGS_append_galaxy4k = " -DBROADCOM_PLATFORM "
CXXFLAGS_append_galaxy4k = " -DBROADCOM_PLATFORM "
CFLAGS_append_revo4k = " -DBROADCOM_PLATFORM "
CXXFLAGS_append_revo4k = " -DBROADCOM_PLATFORM "

FILESEXTRAPATHS_prepend := "${THISDIR}/qtwebkit-git:"
