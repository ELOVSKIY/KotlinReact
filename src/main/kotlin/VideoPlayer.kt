import kotlinx.css.*
import react.*
import react.dom.h3
import react.dom.img
import styled.css
import styled.styledDiv

@JsName("default")
external interface VideoPlayerProps: RProps {
    var video: Video
}

class VideoPlayer : RComponent<VideoPlayerProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            styledDiv {
                css {
                    display = Display.flex
                    marginBottom = 10.px
                }
                emailShareButton {
                    attrs.url = props.video.videoUrl
                    emailIcon {
                        attrs.size = 32
                        attrs.round = true
                    }
                }
                telegramShareButton {
                    attrs.url = props.video.videoUrl
                    telegramIcon {
                        attrs.size = 32
                        attrs.round = true
                    }
                }
            }
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
            h3 {
                + "${props.video.speaker} : ${props.video.title}"
            }
            reactPlayer {
                attrs.url = props.video.videoUrl
            }
        }
    }
}

fun RBuilder.videoPlayer(handler: VideoPlayerProps.() -> Unit): ReactElement {
    return child(VideoPlayer::class) {
        this.attrs(handler)
    }
}