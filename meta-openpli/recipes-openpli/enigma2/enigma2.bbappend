RRECOMMENDS_${PN}_remove_exteplayeronly = " \
        gstreamer1.0-plugin-subsink \
        ${GST_BASE_RDEPS} \
        ${GST_GOOD_RDEPS} \
        ${GST_BAD_RDEPS} \
        ${GST_UGLY_RDEPS} \
        "

SRC_URI = "${GITHUB_URI}/MastaG/${BPN}.git;branch=${ENIGMA2_BRANCH}"
