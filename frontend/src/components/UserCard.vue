<template>
    <div class="user-card">
      <h3>{{ user.name }}</h3>
      <p>Email: {{ user.email }}</p>
      <router-link :to="'/users/' + user.id"> Zobacz szczegóły</router-link>
      <button @click="deleteUser"> Usuń</button>
    </div>
  </template>
   
  <script>
  import apiClient from '@/api/axios.js';
   
  export default {
    props: { user: Object },
    methods: {
      deleteUser() {
        apiClient.delete(`/users/${this.user.id}`)
          .then(() => {
            alert('Użytkownik usunięty!');
            this.$emit('userDeleted', this.user.id); // Emisja eventu
          })
          .catch(error => {
            console.error('Błąd usuwania użytkownika:', error);
          });
      }
    }
  };
  </script>