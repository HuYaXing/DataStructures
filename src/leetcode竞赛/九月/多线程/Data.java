package leetcode竞赛.九月.多线程;

/**
 * @author ：huyaxing
 * @date ：Created in 2020/9/25 下午2:06
 */
public class Data {

    private String htmlContent;
    private String taskTag;
    private String url;

    public Data(String htmlContent, String taskTag, String url) {
        this.htmlContent = htmlContent;
        this.taskTag = taskTag;
        this.url = url;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getTaskTag() {
        return taskTag;
    }

    public void setTaskTag(String taskTag) {
        this.taskTag = taskTag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
