# CircleImageViewByDraw   
##Usage
##Demo
![](https://github.com/louxin2015/CircleImageViewByDraw/blob/master/preview_1.png)
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
```
##Attributes

|name|format|description|
|:---:|:---:|:---:|
| circleTitle | String |设置title
| circleContent | String |设置详情
| circleAngle | integer |初始角度  3点位置为0度
| circleAllAngle | integer |转过的角度
| circleProgress | integer |当前百分比值
| circleMaxProgress | integer |百分比最大值
| circleTitleSize | dimension |主题字体大小
| circleContentSize | dimension |详情字体大小
| circletitleColor | color |主题字体颜色
| circlecontentColor | color |详情字体颜色
| circleDefaultColor | color |圆默认颜色
| circleColor | color |圆百分比颜色
| circleStrokeWidth | integer |圆线宽度


