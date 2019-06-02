package eoinahern.ie.movietrailerapp.data.model

data class StreamBody(
    var content_id: String,
    private val audio_quality: String = "2.0",
    private val content_type: String = "movies",
    private val device_serial: String = "device_serial_1",
    private val device_stream_video_quality: String = "FHD",
    private val player: String = "android:PD-NONE",
    private val subtitle_language: String = "MIS",
    private val video_type: String = "trailer"
)