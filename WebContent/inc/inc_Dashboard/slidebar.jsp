<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="app-sidebar sidebar-shadow">
     <div class="app-header__logo">
         <div class="logo-src"></div>
         <div class="header__pane ml-auto">
             <div>
                 <button type="button" class="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar">
                     <span class="hamburger-box">
                         <span class="hamburger-inner"></span>
                     </span>
                 </button>
             </div>
         </div>
     </div>
     <div class="app-header__mobile-menu">
         <div>
             <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
                 <span class="hamburger-box">
                     <span class="hamburger-inner"></span>
                 </span>
             </button>
         </div>
     </div>
     <div class="app-header__menu">
         <span>
             <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
                 <span class="btn-icon-wrapper">
                     <i class="fa fa-ellipsis-v fa-w-6"></i>
                 </span>
             </button>
         </span>
     </div>
         <div class="scrollbar-sidebar ps ps--active-y">
             <div class="app-sidebar__inner">
                 <ul class="vertical-nav-menu metismenu">
                     <li class="app-sidebar__heading">Dashboards</li>
                     <li>
                         <a href="index.html" class="mm-active">
                             <i class="metismenu-icon pe-7s-rocket"></i>
                             Dashboard RDV
                         </a>
                     </li>
                     <li class="app-sidebar__heading">Gestion Employé</li>
                     <li>
                         <a href="employe">
                             <i class="metismenu-icon pe-7s-display2"></i>
                             Afficher Employe
                         </a>
                     </li>
                     <li>
                         <a href="?do=ajouter">
                             <i class="metismenu-icon pe-7s-display2"></i>
                             Ajouter Employe
                         </a>
                     </li>
                     <li>
                         <a href="?do=modifier">
                             <i class="metismenu-icon pe-7s-display2"></i>
                             Modifier Employe
                         </a>
                     </li>
                 </ul>
             </div>
         <div class="ps__rail-x" style="left: 0px; bottom: 0px;"><div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__rail-y" style="top: 0px; height: 597px; right: 0px;"><div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 527px;"></div>
      	</div>
     </div>
</div>