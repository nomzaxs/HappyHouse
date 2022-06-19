<template>
  <!-- <b-container
    fluid
    id="map"
    ref="map"
    style="width: 100%; height: 1000px; border-radius: 25px"
  > -->
  <div class="map_wrap">
    <div
      id="map"
      style="width: 100%; height: 100%; position: relative; overflow: hidden"
    ></div>
    <ul id="category">
      <li id="BK9" data-order="0">
        <span class="category_bg bank"></span>
        은행
      </li>
      <li id="MT1" data-order="1">
        <span class="category_bg mart"></span>
        마트
      </li>
      <li id="PM9" data-order="2">
        <span class="category_bg pharmacy"></span>
        약국
      </li>
      <li id="OL7" data-order="3">
        <span class="category_bg oil"></span>
        주유소
      </li>
      <li id="CE7" data-order="4">
        <span class="category_bg cafe"></span>
        카페
      </li>
      <li id="CS2" data-order="5">
        <span class="category_bg store"></span>
        편의점
      </li>
    </ul>
  </div>
  <!-- </b-container> -->
</template>

<script>
let kakao = window.kakao;

export default {
  name: "HouseMap",
  props: {
    apts: Array,
  },
  data() {
    return {
      mapInstance: null,
      postions: {},
    };
  },
  mounted() {
    // DOM 생성 후 지도 넣기
    this.initMap();
  },
  watch: {
    apts() {
      this.initMap();
      // console.log(this.mapInstance);
      if (this.apts.length > 0) {
        this.mapInstance.setCenter(
          new kakao.maps.LatLng(this.apts[0].item.lat, this.apts[0].item.lng)
        );

        this.apts.forEach((each) => {
          this.positions += {
            lat: each.item.lat,
            lng: each.item.lng,
          };
        });

        this.makeMarker();
      }
    },
  },
  methods: {
    initMap() {
      let container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
      let options = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(35.20436, 126.80716), //지도의 중심좌표.
        level: 3, //지도의 레벨(확대, 축소 정도)
      };
      this.mapInstance = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
      this.mapInstance.addOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);
    },

    makeMarker() {
      let imageSrc =
        "https://img.icons8.com/doodle/96/000000/google-maps-new.png";
      for (let i = 0; i < this.apts.length; i++) {
        // 마커 이미지의 이미지 크기 입니다
        let imageSize = new kakao.maps.Size(35, 35);

        // 마커 이미지를 생성합니다
        let markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

        let content = this.apts[i].item.apartmentName;

        // 마커를 생성합니다
        let marker = new kakao.maps.Marker({
          map: this.mapInstance, // 마커를 표시할 지도
          position: new kakao.maps.LatLng(
            this.apts[i].item.lat,
            this.apts[i].item.lng
          ), // 마커를 표시할 위치
          title: this.apts[i].item.apartmentName, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage, // 마커 이미지
        });

        // 마커에 표시할 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({
          content: content, // 인포윈도우에 표시할 내용
        });

        //마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
        // 이벤트 리스너로는 클로저를 만들어 등록합니다
        // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
        kakao.maps.event.addListener(
          marker,
          "mouseover",
          this.makeOverListener(this.mapInstance, marker, infowindow)
        );

        kakao.maps.event.addListener(
          marker,
          "mouseout",
          this.makeOutListener(infowindow)
        );

        marker.setMap(this.mapInstance);
      }
      this.mapInstance.setLevel(3);
    },
    makeOverListener(map, marker, infowindow) {
      return function () {
        infowindow.open(map, marker);
      };
    },
    makeOutListener(infowindow) {
      return function () {
        infowindow.close();
      };
    },
  },
};
</script>

<style scoped>
.map_wrap,
.map_wrap * {
  margin: 0;
  padding: 0;
  font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
  font-size: 12px;
}
.map_wrap {
  position: relative;
  width: 100%;
  height: 1000px;
}

.map {
  border-radius: 5px;
}

#category {
  position: absolute;
  top: 10px;
  left: 10px;
  border-radius: 5px;
  border: 1px solid #909090;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
  background: #fff;
  overflow: hidden;
  z-index: 2;
}
#category li {
  float: left;
  list-style: none;
  width: 50px;
  border-right: 1px solid #acacac;
  padding: 6px 0;
  text-align: center;
  cursor: pointer;
}
#category li.on {
  background: #eee;
}
#category li:hover {
  background: #ffd900;
  border-left: 1px solid #acacac;
  margin-left: -1px;
}
#category li:last-child {
  margin-right: 0;
  border-right: 0;
}
#category li span {
  display: block;
  margin: 0 auto 3px;
  width: 27px;
  height: 28px;
}
#category li .category_bg {
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png)
    no-repeat;
}
#category li .bank {
  background-position: -10px 0;
}
#category li .mart {
  background-position: -10px -36px;
}
#category li .pharmacy {
  background-position: -10px -72px;
}
#category li .oil {
  background-position: -10px -108px;
}
#category li .cafe {
  background-position: -10px -144px;
}
#category li .store {
  background-position: -10px -180px;
}
#category li.on .category_bg {
  background-position-x: -46px;
}
.placeinfo_wrap {
  position: absolute;
  bottom: 28px;
  left: -150px;
  width: 300px;
}
.placeinfo {
  position: relative;
  width: 100%;
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  padding-bottom: 10px;
  background: #fff;
}
.placeinfo:nth-of-type(n) {
  border: 0;
  box-shadow: 0px 1px 2px #888;
}
.placeinfo_wrap .after {
  content: "";
  position: relative;
  margin-left: -12px;
  left: 50%;
  width: 22px;
  height: 12px;
  background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
}
.placeinfo a,
.placeinfo a:hover,
.placeinfo a:active {
  color: #fff;
  text-decoration: none;
}
.placeinfo a,
.placeinfo span {
  display: block;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
.placeinfo span {
  margin: 5px 5px 0 5px;
  cursor: default;
  font-size: 13px;
}
.placeinfo .title {
  font-weight: bold;
  font-size: 14px;
  border-radius: 6px 6px 0 0;
  margin: -1px -1px 0 -1px;
  padding: 10px;
  color: #fff;
  background: #d95050;
  background: #d95050
    url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
    no-repeat right 14px center;
}
.placeinfo .tel {
  color: #0f7833;
}
.placeinfo .jibun {
  color: #999;
  font-size: 11px;
  margin-top: 0;
}
</style>
