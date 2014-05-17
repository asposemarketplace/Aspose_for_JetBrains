    package icons;
     
    import com.intellij.openapi.util.IconLoader;
     
    import javax.swing.*;

    public class AsposeIcons {
    private static Icon load(String path) {
    return IconLoader.getIcon(path, AsposeIcons.class);
    }

    public static final Icon AsposeMedium = load("/resources/asposeMedium.png");
    public static final Icon AsposeLogo = load("/resources/asposeSmall.png");
    public static final Icon AsposePlugin = load("/resources/aspose.png");
    public static final Icon AsposeProject = load("/resources/aspose.png");
    public static final Icon AsposeBanner = load("/resources/long_bannerIntelliJ.png");


    }