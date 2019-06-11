package tagservice.repository;

import tagservice.model.entity.Tag;

public interface ITagDao {

    Tag save(Tag post);

    boolean exists(String tagString);

    Tag getByTagString(String tagString);

}
