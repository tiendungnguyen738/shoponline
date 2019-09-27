$(document).ready(function(){
	var idProduct = 0;
    var files= [];
	var nameImage = "";
	$("#uploadhinhanh").change(function(event){
		 files = event.target.files;
	       nameImage = files[0].name;
	       var forms = new FormData();
	       forms.append("file",files[0]);
	       $.ajax({
	           url:"/shoponline/api-product-manage/upload-image",
	           type:"POST",
	           data:forms,
	           processData: false,
	           contentType: false,
	           enctype:"multipart/form-data",
	           success:function(value){
	               alert("upload thanh cong");
	           }
	       })
	})
	
	$("body").on("click",".btn-detail",function(){
		var This = $("#idChiTietSanPham").clone();
		This.removeAttr("id");
		This.appendTo($("#containerChitietsanpham"));		
	})
	
	$("body").delegate(".btn-remove","click",function(){
		this.closest(".chitietsanpham").remove();
	})
	
	$("body").on("click","#btn-themSanPham",function(){
		var productForm = {};
		var productDetail =[];
		
		var form  = $("#form-sanpham").serializeArray();
		$.each(form, function(i, field){
		   productForm[field.name] = field.value;
		  });	
		
		$("#containerChitietsanpham > .chitietsanpham").each(function(){
			objectChiTiet = {};
            mauSanPham = $(this).find('select[name="mau"]').val();
            sizeSanPham = $(this).find('select[name="size"]').val();
            soLuong = $(this).find('input[name="soluong"]').val();

            objectChiTiet["mauSanPham"] = mauSanPham;
            objectChiTiet["sizeSanPham"] = sizeSanPham;
            objectChiTiet["soLuong"] = soLuong;

            productDetail.push(objectChiTiet);
		});
		
		productForm["productDetail"] = productDetail;
		productForm["nameImage"] = nameImage;
		var formInfor = JSON.stringify(productForm);
		console.log(formInfor);
		$.ajax({
			 url:"/shoponline/api-product-manage/add-product",
			 type:"POST",
			 data:{
				 formInfor:formInfor
			 },
			 success:function(value){
				 alert("add success");
			 }
			 
		})
	})
	
	$("body").on("click","#editProduct",function(){
        $("#btn-themSanPham").addClass("hide");
        $("#uploadhinhanh").prop('readonly', true);
		idProduct = $(this).closest("tr").find("input[name='sport']").val();
		$.ajax({
			url:"/shoponline/api-product-manage/edit-product",
			type:"POST",
			data:{
				idProduct:idProduct
			},
			success:function(value){
				   $("#tenSanPham").val(value.productName);
	               $("#giaTien").val(value.price);
	               $("#danhmucsanpham").val(value.category.category_id);

	               $("#containerChitietsanpham").html("");

	               for( i in value.productsDetail){
	                   var chitietsanpham = $("#idChiTietSanPham").clone().removeAttr("id");
	                   chitietsanpham.find("#mau1").val(value.productsDetail[i].color.id);
	                   chitietsanpham.find("#size1").val(value.productsDetail[i].size.id);
	                   chitietsanpham.find("#soLuong1").val(value.productsDetail[i].soLuong);
	                   $("#containerChitietsanpham").append(chitietsanpham);
	               }
	               $("#cancel").removeClass("hide");
	               $("#capNhatSanPham").removeClass("hide");
			}
		})
	})
	
	$("body").on("click","#cancel",function(){
       $("#btn-themSanPham").removeClass("hide");
       $(this).addClass("hide");
       $("#capNhatSanPham").addClass("hide");
   })
	
	$("#allBox").change(function(){
       if(this.checked){
           $("#table-product input").each(function () {
                $(this).prop("checked",true);
           })
       }else {
           $("#table-product input").each(function () {
               $(this).prop("checked",false);
           })
       }
   })
   
   $("#button-delete").click(function(){
	   var idProduct;
	   $("#table-product input[name='sport']:checked").each(function () {
		   idProduct = $(this).val();
		   $(this).closest("tr").remove();
		   $.ajax({
			   url:"/shoponline/api-product-manage/delete-product",
			   type:"POST",
			   data:{
				   idProduct:idProduct
			   },
			   success:function(value){
				   alert("delete success !!!");
			   }
		   })
      })
   })
	
	$("body").on("click","#capNhatSanPham",function(){
		var formData = $("#form-sanpham").serializeArray();
        json = {};
        arrayChiTiet = [];
        $("#containerChitietsanpham > .chitietsanpham").each(function(){
            objectChiTiet = {};
            mauSanPham = $(this).find('select[name="mau"]').val();
            sizeSanPham = $(this).find('select[name="size"]').val();
            soLuong = $(this).find('input[name="soluong"]').val();

            objectChiTiet["mauSanPham"] = mauSanPham;
            objectChiTiet["sizeSanPham"] = sizeSanPham;
            objectChiTiet["soLuong"] = soLuong;

            arrayChiTiet.push(objectChiTiet);
        })

        $.each(formData,function(i,field){
            json[field.name] = field.value;
        })
        json["chiTietSanPham"] = arrayChiTiet;
        json["idProduct"] = idProduct;
        $.ajax({
            url:"/shoponline/api-product-manage/capNhapSanPham",
            type:"POST",
            data:{
                dataJson:JSON.stringify(json)
            },
            success:function(value){
                alert("update product success");
            }
        })
	})
	
	
})