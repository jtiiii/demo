package cn.funeralobjects.demo.exec.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author FuneralObjects
 * Create date: 2020/4/3 11:11 AM
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormatInfo {
    @JsonProperty("format_id")
    private String id;
    private String acodec;
    private String vcodec;
    @JsonProperty("format_note")
    private String formatNote;
    @JsonProperty("filesize")
    private Long fileSize;
    private String ext;
    private Long asr;

}
