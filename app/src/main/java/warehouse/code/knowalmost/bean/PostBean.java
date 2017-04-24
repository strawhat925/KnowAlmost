package warehouse.code.knowalmost.bean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.LinkedList;

/**
 * ${DESCRIPTION}
 * package warehouse.code.knowalmost.bean
 *
 * @author zli [liz@yyft.com]
 * @version v1.0
 * @create 2017-04-22 14:58
 **/
public class PostBean {
    private int id;
    private String text;
    private String imageUrl;
    private int image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public static LinkedList<PostBean> parse(String json) {
        LinkedList<PostBean> postBeanLinkedList = new LinkedList<PostBean>();
        JSONTokener jsonTokener = new JSONTokener(json);
        JSONArray jsonArray;
        try {
            jsonArray = (JSONArray) jsonTokener.nextValue();
            for (int i = 0; i < jsonArray.length(); i++) {
                PostBean postBean = new PostBean();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                postBean.setText(jsonObject.getString("title"));
                postBean.setImageUrl(jsonObject.getString("image"));
                postBeanLinkedList.add(postBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return postBeanLinkedList;
    }
}
