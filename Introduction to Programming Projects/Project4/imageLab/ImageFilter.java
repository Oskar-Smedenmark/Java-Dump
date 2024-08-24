public interface ImageFilter {

    public String getMenuName();
    public void apply(Picture src, Picture dest);

}