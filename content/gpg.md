# Generate gpg key


```shell
gpg --full-generate-key
```

|Prompt | Response |	Note |
| ----- |:--------:| -----:|
|Please select what kind of key you want: |	(1) RSA and RSA (default) | GitHub supported GPG key algorithms |
|What keysize do you want: | 4096 | GitHub minimum is 4096 |
|Please specify how long the key should be valid: |	1y	No requirements from GitHub ||
|Real name | name ||
|Email address: | email address | Must match your verified email address with GitHub|
|Comment: | ||

```shell
# Change git config to use the generated key
git config --global user.signingkey $PUB_KEY
# Enable gpgsign
git config --global commit.gpgsign true
# Add key to https://github.com/settings/keys
gpg --armor --export  $PUB_KEY | pbcopy
```


## Reference

- https://cloudlumberjack.com/posts/setup-github-verified-commits-for-vscode/
