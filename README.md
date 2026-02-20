# Projet DevOps - A.U. 2025-2026

[cite_start]Ce projet a pour objectif d'évaluer la mise en place d'une chaîne DevOps complète autour d'une application Spring Boot[cite: 34]. [cite_start]Il couvre tout le cycle de vie, du code source à la livraison continue[cite: 34].

## 🏗️ Architecture du Projet
[cite_start]L'infrastructure repose sur les outils suivants, intégrés dans un environnement Ubuntu/VMware[cite: 8, 12]:
* [cite_start]**Gestion de Version :** GitHub pour le stockage du code source[cite: 22].
* [cite_start]**Build :** Maven pour la compilation et la gestion des dépendances[cite: 22, 35].
* [cite_start]**Automation :** Jenkins pour l'orchestration de la pipeline[cite: 25, 35, 42].
* [cite_start]**Analyse de Qualité :** SonarQube pour l'analyse statique du code[cite: 10, 35, 40].
* [cite_start]**Conteneurisation :** Docker et Docker Hub pour la création et le stockage des images[cite: 18, 43, 48].
* [cite_start]**Monitoring :** Prometheus et Grafana pour le suivi des performances[cite: 28, 32, 33, 35].

## 🚀 Pipeline CI/CD
[cite_start]La pipeline Jenkins automatise les étapes suivantes[cite: 34, 35, 42]:
1. [cite_start]**Pull :** Récupération du code depuis le dépôt GitHub[cite: 24].
2. [cite_start]**Build :** Exécution des commandes Maven (`clean`, `install`, `package`)[cite: 23, 38].
3. [cite_start]**Analyse :** Scan du code par SonarQube[cite: 17, 40].
4. [cite_start]**Dockerization :** Création d'une image Docker de l'application[cite: 43, 49].
5. [cite_start]**Push :** Envoi de l'image vers Docker Hub[cite: 18].
6. [cite_start]**Déploiement :** Livraison continue avec Docker (Spring et MySQL)[cite: 43].
