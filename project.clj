(defproject fullcontact/full.cache "1.2.2"
  :description "In-memory + memcache caching for Clojure with async loading."
  :url "https://github.com/contactsplusapp/full.cache"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}
  :repositories [["fullcontact" {:url "https://contactsplus.jfrog.io/artifactory/repo"}]
                 ["releases" {:url "https://contactsplus.jfrog.io/artifactory/libs-release-local"}]
                 ["snapshots" {:url "https://contactsplus.jfrog.io/artifactory/libs-snapshot-local"}]]
  :deploy-repositories [["releases" {:url "https://contactsplus.jfrog.io/artifactory/libs-release-local" :sign-releases false}]
                        ["snapshots" {:url "https://contactsplus.jfrog.io/artifactory/libs-snapshot-local" :sign-releases false}]]
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [net.jodah/expiringmap "0.4.1"]
                 [net.spy/spymemcached "2.12.2"]
                 [com.taoensso/nippy "2.14.0"]
                 [fullcontact/full.core "1.1.3"
                  :exclusions [org.clojure/clojurescript]]
                 [fullcontact/full.async "1.1.1"]]
  :plugins [[lein-midje "3.2.2"]]
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]
  :profiles {:dev {:dependencies [[midje "1.9.9"]]}})
