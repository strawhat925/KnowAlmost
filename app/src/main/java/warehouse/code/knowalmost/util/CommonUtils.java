package warehouse.code.knowalmost.util;

import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

import warehouse.code.knowalmost.R;

/**
 * ${DESCRIPTION}
 * package warehouse.code.knowalmost.util
 *
 * @author zli [liz@yyft.com]
 * @version v1.0
 * @create 2017-04-22 15:17
 **/
public class CommonUtils {

    public static String getText(String text) {
        int length = text.length();
        if (length < 13) {
            return text;
        } else if (length > 24) {
            text = text.substring(0, 24);
        }
        String textHeadString = text.substring(0, 13);
        text = text.replace(textHeadString, textHeadString + "\n");
        return text;
    }


    public static DisplayImageOptions getImageOption(Context context) {
        File cacheDir = StorageUtils.getOwnCacheDirectory(context, "imageloader/cache");
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                //max width, max height，即保存的每个缓存文件的最大长宽
                .memoryCacheExtraOptions(480, 800)
                // Can slow ImageLoader, use it carefully (Better don't use it)/设置缓存的详细信息，最好不要设置这个
                .diskCacheExtraOptions(480, 800, null)
                ////线程池内加载的数量
                .threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                // You can pass your own memory cache implementation/你可以通过自己的内存缓存实现
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .diskCacheSize(2 * 1024 * 1024)
                ////将保存的时候的URI名称用MD5 加密
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                //缓存的文件数量
                .diskCacheFileCount(100)
                //自定义缓存路径
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                // connectTimeout (5 s), readTimeout (30 s)超时时间
                .imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000))
                // Remove for release app
                .writeDebugLogs()
                .build();
        ImageLoader.getInstance().init(configuration);
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                //设置图片在下载期间显示的图片
                .showImageOnLoading(R.drawable.ic_launcher)
                //设置图片Uri为空或是错误的时候显示的图片
                .showImageForEmptyUri(R.drawable.ic_launcher)
                //设置图片加载/解码过程中错误时候显示的图片
                .showImageOnFail(R.drawable.ic_launcher)
                //设置下载的图片是否缓存在内存中
                .cacheInMemory(true)
                //设置下载的图片是否缓存在盘中
                .cacheOnDisk(true)
                //是否考虑JPEG图像EXIF参数（旋转，翻转）
                .considerExifParams(true)
                //设置图片以如何的编码方式显示
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                //设置图片在下载前是否重置，复位
                .resetViewBeforeLoading(true)
                //是否设置为圆角，弧度为多少
                .displayer(new RoundedBitmapDisplayer(20))
                //是否图片加载好后渐入的动画时间
                .displayer(new FadeInBitmapDisplayer(100))
                .build();
        return options;
    }
}
