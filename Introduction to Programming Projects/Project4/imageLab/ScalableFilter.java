public interface ScalableFilter {

    public String getMenuName();
    public void apply(Picture src, Picture dest, double scale);

}