# CircleImageViewByDraw   
##Usage

###1. 
```java
/**
     * 获取最大百分比值
     * @return
     */
    public int getMaxProgress() {
        return mMaxProgress;
    }

    /**
     * 设置最大百分比值
     * @param maxProgress
     */
    public void setMaxProgress(int maxProgress) {
        this.mMaxProgress = maxProgress;
    }

    /**
     * 设置当前百分比值
     * @param progress
     */
    public void setProgress(int progress) {
        this.mProgress = progress;
        this.invalidate();
    }

    public String getTitle() {
        return Title;
    }

    /**
     * 设置title
     * @param Title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getContent() {
        return content;
    }

    /**
     * 设置content
     * @param content
     */
    public void setContent(String content) {
        this.content = content;

    }

    /**
     * 设置初始化角度
     * @param angle
     */
    public void setStartAngle(int angle) {
        this.angle = angle;
    }

    /**
     * 设置转过的角度
     * @param angle
     */
    public void setAllAngle(int angle) {
        this.allAngle = angle;
    }
