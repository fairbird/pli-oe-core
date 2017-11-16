FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://backport_cplusplus98_support.patch "

CXXFLAGS += "-std=gnu++98 -fpermissive"
