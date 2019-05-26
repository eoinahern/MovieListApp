package eoinahern.ie.movietrailerapp.data.model

data class StreamBody(
    private val audio_quality: String = "2.0",
    var content_id: String,
    private val content_type: String = "movies",
    private val device_serial: String = "device_serial_1",
    private val device_stream_video_quality: String = "FHD",
    private val player: String = "android:PD-NONE",
    private val subtitle_language: String = "MIS"
)