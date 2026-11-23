# Saba Madadi — Academic Portfolio

This is the complete static website for **https://sabamadadi.github.io/**.

## Website pages

- `index.html` — academic portfolio and profile photo
- `blog.html` — archived blog posts, with original photos, GIF, and videos
- `sleep-stage-classification.html` — sleep staging literature review

## Media folder

```text
assets/
├── profile.jpg            # Profile photo shown on the homepage
├── hero.png               # Homepage banner
└── blog/
    ├── images/            # Blog post images
    ├── gifs/              # Blog animation
    └── videos/            # Two project demonstration videos
```

All local file paths are relative to the repository root. The website does not require a build step or npm installation.

## Publish to GitHub Pages

1. Extract `saba-academic-v32.zip` to a folder on your computer.
2. Open your `sabamadadi.github.io` repository on GitHub.
3. Remove old website files that you no longer want to keep.
4. Upload **all files and folders from inside the extracted folder**, not the ZIP itself or an extra enclosing folder.
5. Check that `index.html`, `blog.html`, `sleep-stage-classification.html`, and the `assets` folder appear directly at the repository root.
6. Commit the changes and wait for GitHub Pages to deploy.

### If the profile photo is missing

Check that this exact URL works after publishing:
`https://sabamadadi.github.io/assets/profile.jpg`

If the image opens but the page is outdated, hard-refresh the homepage (Ctrl+Shift+R). File and folder names are case-sensitive on GitHub Pages.

## External resources

Canva presentations, Google Docs, and external social/project links open on their respective websites. Their availability depends on the original sharing settings.

## Maintenance

- To change your photo, replace `assets/profile.jpg` (keep the same filename).
- To update the homepage, edit `index.html`.
- To update blog posts, edit `blog.html` and place media under `assets/blog/`.
- To update the literature review, edit `sleep-stage-classification.html`.
