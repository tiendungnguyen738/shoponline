$(document).ready(function(){

	$(".btn-add-giohang").click(function(){
		var productName = $(".productName").text();
		var productId = $(".productName").attr("data-idPd");
		var productPrice = $(".productPrice").attr("data-price");
		var sizeId = $(this).closest(".danger").find(".sizeName").attr("data-IdS");
		var colorId = $(this).closest(".danger").find(".colorName").attr("data-idC");
		var colorName= $(this).closest(".danger").find(".colorName").text();
		var sizeName= $(this).closest(".danger").find(".sizeName").text();
		var imageProduct = $(".imageProduct").attr("data-image");
		var productDetailId = $(this).closest(".danger").find(".sizeName").attr("data-prDtID");
		$.ajax({
			url: '/shoponline/api/them-gio-hang',
            type: 'GET',
            data: {
            	productName:productName,
            	productId:productId,
            	productPrice:productPrice,
            	sizeId:sizeId,
            	colorId:colorId,
            	colorName:colorName,
            	sizeName:sizeName,
            	image:imageProduct,
            	productDetailId:productDetailId
            	},
            	success:function(value){
            		alert("thêm giỏ hàng thành công!!!");
            		$("#soLuongSanPhamThemVaoGioHang").html(value);
            	}
		});
	});
	
	var tongTienThanhToan = 0;
	
	function tongSoTienMua(){
		$(".thongTinSanPham").each(function(){
			tongTienThanhToan = parseInt(tongTienThanhToan) + parseInt($(this).find(".total-col").attr("data-pricePro"));
		})
		$("#tongTienThanhToan").html("$"+tongTienThanhToan);
		return tongTienThanhToan;
	};
	
	tienKhiVuaLoadTrang();
	
	tongSoTienMua();
	
	
	function tienKhiVuaLoadTrang(){
		var tienMoiLoad= 0;
		$(".thongTinSanPham").each(function(){
			tienMoiLoad = parseInt($(this).find(".thayDoiSoLuong").val()) * parseInt($(this).find(".priceProduct").attr("data-price"));
			$(this).find(".total-col").html("$"+tienMoiLoad);
			$(this).find(".total-col").attr({"data-pricePro":tienMoiLoad});
		})
	}
	
	$(".thayDoiSoLuong").change(function(){
		var tongTienMotSanPham = parseInt($(this).closest(".thongTinSanPham").find(".priceProduct").attr("data-price"))*$(this).val();
		var This = $(this).closest(".thongTinSanPham").find(".total-col");
		This.html("$ "+tongTienMotSanPham);
		$(this).closest(".thongTinSanPham").find(".total-col").attr({"data-pricePro":tongTienMotSanPham});
		
		tongTienThanhToan = 0 ;
		
		$(".thongTinSanPham").each(function(){
			tongTienThanhToan = parseInt(tongTienThanhToan) + parseInt($(this).find(".total-col").attr("data-pricePro"));
		})
		$("#tongTienThanhToan").html("$"+tongTienThanhToan);
		
		var maSp = $(this).closest(".thongTinSanPham").find(".maSanPham").attr("data-masp");
		var maSize = $(this).closest(".thongTinSanPham").find(".size-col").attr("data-masize");
		var maMau = $(this).closest(".thongTinSanPham").find(".color-col").attr("data-mamau");
		var soLuong = $(this).val();
		
		$.ajax({
			url:'/shoponline/api/update-gio-hang',
			type:'GET',
			data:{
				maSp:maSp,
				maSize:maSize,
				maMau:maMau,
				soLuong:soLuong
			}
		});
	})
	
	$(".btn-xoaGioHang").click(function(){
		var maSp = $(this).closest(".thongTinSanPham").find(".maSanPham").attr("data-masp");
		var maSize = $(this).closest(".thongTinSanPham").find(".size-col").attr("data-masize");
		var maMau = $(this).closest(".thongTinSanPham").find(".color-col").attr("data-mamau");
		var This = $(this);
		alert("fdf");
		$.ajax({
			url:'/shoponline/api/delete-gio-hang',
			type:'GET',
			data:{
				maSp:maSp,
				maSize:maSize,
				maMau:maMau
			},
			success:function(){
				This.closest(".thongTinSanPham").remove();
			}
		})
	})
	
	$("body").on("click","#loadmore",function(){
		var tongSoLuongSanPham = $(this).attr("data-trangThu");
		var count = 0;
		
		$(".productLoadMoreeee").each(function(){
			count++;
		})
		if(tongSoLuongSanPham == count){
			
		}
		else{
			$.ajax({
					url:'/shoponline/loadmore',
					type:'POST',
					data:{
						count:count
					},
					success:function(value){
						
						for(i in value){
							var anh = '<img src="http://localhost:8080/shoponline/resources/image/products/'+value[i].image+'" alt="" class="productLoadMoreeee">'
							var link = '<a href="/shoponline/productDetail/'+value[i].id+'">'
							
							var html = '';
							html += link
								 +'<div class="col-lg-3 col-sm-6">'
								 +'<div class="product-item">'
								 +'<div class="pi-pic">'
								 +anh
								 +'<div class="pi-links">'
								 +'<a href="/shoponline/productDetail/'+value[i].id+'"'+ 
								 'class="add-card"><i class="flaticon-bag"></i><span>ADD TO CART</span></a>'
								 +'<a href="#" class="wishlist-btn"><i class="flaticon-heart"></i></a>'
								 +'</div>'
								 +'</div>'
								 +'<div class="pi-text">'
								 +'<h6>'+value[i].price+'</h6>'
								 +'<p>'+value[i].productName+' </p>'
								 +'</div>'
								 +'</div>'
								 +'</div>'
								 +'</a>'
							$(".productLoadMores").append(html);
						}
					}
				})
		}
	})
});