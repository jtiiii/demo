package cn.funeralobjects.demo.exec.youtube;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author FuneralObjects
 * Create date: 2020/4/3 11:06 AM
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WatchInfo {
    /**
     * 视频id
     */
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 长标题
     */
    private String fullTitle;
    /**
     * 上传日期
     */
    @JsonProperty("upload_date")
    private String uploadDate;
    /**
     * 帧率
     */
    private Integer fps;
    /**
     * 上传者
     */
    private String uploader;
    @JsonProperty("uploader_id")
    private String uploaderId;
    private String thumbnail;
    @JsonProperty("channel_id")
    private String channelId;
    @JsonProperty("is_live")
    private Boolean isLive;
    @JsonProperty("format_id")
    private String formatId;
    @JsonProperty("channel_url")
    private String channelUrl;
    private String description;

    @JsonProperty("formats")
    private List<FormatInfo> formats;
}
