package dao;

import java.util.ArrayList;

import dto.MovieDto;
import dto.MoviehugiDto;

public interface MovieDao {
	public void insert(MovieDto dto);
	
	public ArrayList<MovieDto> select(MovieDao dao);
	
	public void insert(MoviehugiDto hugi);
}
