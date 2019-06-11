package tagservice.service;

import tagservice.model.entity.Tag;
import tagservice.repository.ITagDao;

public class TagService {

    private ITagDao tagDao;

    public void addTag(String tagString){

        Tag t = this.tagDao.getByTagString(tagString);

        if(t == null){

            t = new Tag(1, tagString);

            this.tagDao.save(t);
            return;
        }
        else{
            t.incrementTimesUsed();

            this.tagDao.save(t);
        }
    }


}
