<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="flex justify-around">
		<c:forEach begin="1" end="${getpeople }" var="i">
				<div style="width: 150px;">
						<table class='table'>
								<tr>
										<td>
												<div>
														<input class="${i}" type="hidden" value="${i}" name="id" />
												</div>
										</td>
								</tr>
								<tr>
										<td>
												<div class="text-center">
													<div id="${i }this" >당첨?</div>
												</div>
										</td>
								</tr>
								<tr>
										<td>
												<div class="text-center">
													<div id="${i }pokename" class="btn btn-outline btn-info  ${i}">안녕</div>
												</div>
										</td>
								</tr>
								<tr>
										<td>
												<div>
													<img id="${i}img" src="" alt="" />
												</div>
										</td>
								</tr>


								<!-- <form onsubmit="confirmclick; return false;"> -->






						</table>
						<script>
		
		$(document).ready(
				function(){
					
				 	$('#confirmData').click(function(){
						var array=[];
						$('.'+${i}).each(function(){
							var key=$(this).attr('name');
							var value=$(this).val().trim();
							var map={};
							map[key]=value;
							array.push(map);
					 	});
						eatmember.push(array);
					 }) 
				
				})
		</script>
						<!-- </form> -->
				</div>
		</c:forEach>
</section>
<!-- to make in this page automatically make array about list[map{}] format
	 with each input data based on ${num } value with concat method-->
<!-- $(document).ready(function(){
			/* $('input').attr('name',$('input').attr('name')+1); */
			$('input').attr('value',$('input').attr('name'));
		}) -->