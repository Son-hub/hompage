package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBclass;

import db.DBclass;
import dto.MovieDto;
import dto.MoviehugiDto;

public class MovieDaoImpl implements MovieDao{

	@Override
	public void insert(MovieDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBclass.condb(); 
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO daum_movie(je,gam,bae,img)");
			sql.append("SELECT ?, ?, ?, ? FROM DUAL WHERE NOT EXISTS");
			sql.append("SELECT je,bae,gam,img FROM movie WHERE je = ?");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, dto.getJe());
			pstmt.setString(2, dto.getGam());
			pstmt.setString(3, dto.getBae());
			pstmt.setString(4, dto.getImg());
			pstmt.setString(5, dto.getJe());
			
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<MovieDto> select(MovieDao dao) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		try {
			conn = DBclass.condb();
			String sql = "SELECT * FROM daum_movie";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MovieDto dto = new MovieDto();
				dto.setJe(rs.getString("je"));
				dto.setBae(rs.getString("bae"));
				dto.setGam(rs.getString("gam"));
				dto.setImg(rs.getString("img"));
				list.add(dto);
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if( rs != null && !rs.isClosed()){
                    rs.close();
                }
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void insert(MoviehugiDto hugi) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBclass.condb(); 
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO movie_hugi(score,hugi)");
				sql.append("SELECT ?, ? FROM DUAL WHERE NOT EXISTS");
				sql.append("SELECT score,hugi FROM  WHERE  = ?");
				pstmt = conn.prepareStatement(sql.toString());
				
				pstmt.setInt(1, hugi.getScore());
				pstmt.setString(2, hugi.getHugi());
				
				int count = pstmt.executeUpdate();
				if (count == 0) {
					System.out.println("데이터 입력 실패");
				} else {
					System.out.println("데이터 입력 성공");
				}

			} catch (Exception e) {
				System.out.println("에러: " + e);
			} finally {
				try {
					if (conn != null && !conn.isClosed()) {
						conn.close();
					}
					if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
	}
}
