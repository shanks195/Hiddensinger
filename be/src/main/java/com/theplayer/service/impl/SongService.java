package com.theplayer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.theplayer.entity.SongEntity;
import com.theplayer.entity.UserEntity;
import com.theplayer.repository.SongRepository;
import com.theplayer.service.ILogService;
import com.theplayer.service.IRatingService;
import com.theplayer.service.ISongService;
import com.theplayer.service.IUserService;

@Service
public class SongService implements ISongService{
	
	@Autowired
	private SongRepository songRepository;
	
	@Autowired
	private IRatingService ratingService;
	
	@Autowired
	private ILogService logService;
	
	@Autowired
	private IUserService userService;

	@Override
	public SongEntity save(SongEntity entity) {
		// TODO Auto-generated method stub
		return songRepository.save(entity);
	}

	@Override
	public List<SongEntity> findAll(Pageable pageable) {
		List<SongEntity> entitys = songRepository.findAll(pageable).getContent();
		return entitys;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return (int) songRepository.count();
	}

	@Override
	public List<SongEntity> findAll() {
		// TODO Auto-generated method stub
		return songRepository.findAll();
	}

	
	public SongEntity deleteSongId(long id) {
		// TODO Auto-generated method stub
		songRepository.deleteById(id);
		return null;
		
	}

	@Override
	public List<SongEntity> findAllByName(String name) {
		// TODO Auto-generated method stub
		return songRepository.findAllByName(name);
	}

	@Override
	public List<SongEntity> findAllOrderByLikesAsc() {
		// TODO Auto-generated method stub
		return songRepository.findByOrderByLikesAsc();
	}

	@Override
	public List<SongEntity> findAllOrderByDislikesAsc() {
		// TODO Auto-generated method stub
		return songRepository.findByOrderByDislikesAsc();
	}

	@Override
	public Long sumTopLike() {
		long count=0;
		List<SongEntity> listTopLike = findAllOrderByLikesAsc();
		int index = listTopLike.size()<30?listTopLike.size():30;
		for(int i=0;i<index;i++) {
			if(listTopLike.get(i).getLikes()!=null) {
				count+=listTopLike.get(i).getLikes();
			}
		}
		return count;
	}

	@Override
	public Long sumTopDislike() {
		long count=0;
		List<SongEntity> listTopDislike = findAllOrderByDislikesAsc();
		int index = listTopDislike.size()<30?listTopDislike.size():30;
		for(int i=0;i<index;i++) {
			if(listTopDislike.get(i).getDislikes()!=null) {
				count+=listTopDislike.get(i).getDislikes();
			}
		}
		return count;
	}

	@Override
	public Float sumScoreSong(Long songId) {
		long sumLikesSong = ratingService.findAllBySubRatingAndSongId("like", songId).size();
		long sumDislikesSong = ratingService.findAllBySubRatingAndSongId("dislike", songId).size();
		long sumViews = logService.findAllBySongId(songId).size();
		long sumViewsTop = sumViewsTop();
		if(sumTopLike()-sumTopDislike()!=0&&sumViewsTop!=0) {
			return (float)((sumLikesSong-sumDislikesSong)*1000/(sumTopLike()-sumTopDislike())
					+(sumViews/sumViewsTop)*2000);
		}else return 0f;
	}

	@Override
	public Long sumViewsTop() {
		List<SongEntity> list = songRepository.findByOrderByViewsAsc();
		long count =0;
		int index = list.size()<30?list.size():30;
		for(int i=0;i<index;i++) {
			if(list.get(i).getViews()!=null) {
				count+=list.get(i).getViews();
			}
		}
		return count;
	}

	@Override
	public SongEntity findOneById(Long id) {
		return songRepository.findOneById(id);
	}

	@Override
	public List<SongEntity> findByCategoryId(Long categoryId) {
		return songRepository.findByCategoryId(categoryId);
	}
	
	public List<SongEntity>  findByAccountId(Long idaccount) {
		 List<SongEntity> list = new ArrayList<SongEntity>();
		 UserEntity user = userService.findOneByAccountId(idaccount);
		 list = songRepository.findAllByUserId(user.getId());
		return list;
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		
	}
	
}
