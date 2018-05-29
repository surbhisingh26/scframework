package com.social.scframework.highchart;

public class Chart {
	
	String plotBackgroundColor;
    String plotBorderWidth;
    Boolean plotShadow;
    Object renderTo;
    public Object getRenderTo() {
		return renderTo;
	}
	public void setRenderTo(Object renderTo) {
		this.renderTo = renderTo;
	}
	String type;
	public String getPlotBackgroundColor() {
		return plotBackgroundColor;
	}
	public void setPlotBackgroundColor(String plotBackgroundColor) {
		this.plotBackgroundColor = plotBackgroundColor;
	}
	public String getPlotBorderWidth() {
		return plotBorderWidth;
	}
	public void setPlotBorderWidth(String plotBorderWidth) {
		this.plotBorderWidth = plotBorderWidth;
	}
	public Boolean getPlotShadow() {
		return plotShadow;
	}
	public void setPlotShadow(Boolean plotShadow) {
		this.plotShadow = plotShadow;
	}
	public String getType() {
		return type;
	}
	public void setType(String string) {
		this.type = string;
	}

}
