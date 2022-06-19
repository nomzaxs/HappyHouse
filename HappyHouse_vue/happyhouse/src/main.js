import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import { BootstrapVue, IconsPlugin, JumbotronPlugin } from "bootstrap-vue";
// Import Bootstrap and BootstrapVue CSS files (order is important)
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

import VeeValidate from "vee-validate";
import Vuex from "vuex";
import setupInterceptors from "./services/setupInterceptors";

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue);
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin);
Vue.use(JumbotronPlugin);

Vue.config.productionTip = false;

Vue.use(VeeValidate, {
  fieldsBagName: "vee-fields",
});
Vue.use(Vuex);

setupInterceptors(store);

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
